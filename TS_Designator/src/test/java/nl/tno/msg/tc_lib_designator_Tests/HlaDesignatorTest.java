package nl.tno.msg.tc_lib_designator_Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import nl.tno.msg.tc_lib_designator.DesignatorCodeEnum16_Alternative;
import nl.tno.msg.tc_lib_designator.DesignatorCodeNameEnum16_Alternative;
import nl.tno.msg.tc_lib_designator.HlaDesignator;
import nl.tno.rpr.datatypes.AccelerationVectorStruct;
import nl.tno.rpr.datatypes.DeadReckoningAlgorithmEnum8;
import nl.tno.rpr.datatypes.EntityIdentifierStruct;
import nl.tno.rpr.datatypes.FederateIdentifierStruct;
import nl.tno.rpr.datatypes.RelativePositionStruct;
import nl.tno.rpr.datatypes.WorldLocationStruct;

class HlaDesignatorTest {
	@Test
	void test() {
		HlaDesignator.init(null, null, null, null);
		HlaDesignator hlaDesignator = new HlaDesignator();

		// Simple test of power
		hlaDesignator.setDesignatorOutputPower((float) 100.123);
		assertEquals((float) 100.123, hlaDesignator.getDesignatorOutputPower());

		// Test of deep copy - initialize d1
		HlaDesignator d1 = new HlaDesignator();

		EntityIdentifierStruct d1EntityId = new EntityIdentifierStruct();
		d1EntityId.setFederateIdentifier(new FederateIdentifierStruct());
		d1EntityId.getFederateIdentifier().setSiteID((short) 11);
		d1EntityId.getFederateIdentifier().setApplicationID((short) 11);
		d1EntityId.setEntityNumber((short) 11);
		d1.setEntityIdentifier(d1EntityId);

		RelativePositionStruct d1RelPos = new RelativePositionStruct();
		d1RelPos.setBodyXDistance(11);
		d1RelPos.setBodyYDistance(11);
		d1RelPos.setBodyZDistance(11);
		d1.setRelativePosition(d1RelPos);

		WorldLocationStruct d1WorldLoc = new WorldLocationStruct();
		d1WorldLoc.setX(11);
		d1WorldLoc.setY(11);
		d1WorldLoc.setZ(11);
		d1.setDesignatorSpotLocation(d1WorldLoc);

		RelativePositionStruct d1RelSpotLoc = new RelativePositionStruct();
		d1RelSpotLoc.setBodyXDistance(11);
		d1RelSpotLoc.setBodyYDistance(11);
		d1RelSpotLoc.setBodyZDistance(11);
		d1.setRelativeSpotLocation(d1RelSpotLoc);

		AccelerationVectorStruct d1Accel = new AccelerationVectorStruct();
		d1Accel.setXAcceleration(11);
		d1Accel.setYAcceleration(11);
		d1Accel.setZAcceleration(11);
		d1.setSpotLinearAccelerationVector(d1Accel);

		d1.setDesignatorCode_Alternative(DesignatorCodeEnum16_Alternative.Other);
		d1.setCodeName_Alternative(DesignatorCodeNameEnum16_Alternative.AH_1_C_NITE);
		d1.setHostObjectIdentifier("11:11:11");
		d1.setDesignatedObjectIdentifier("111:111:111");
		d1.setDeadReckoningAlgorithm(DeadReckoningAlgorithmEnum8.Other);
		d1.setDesignatorEmissionWavelength(11);
		d1.setDesignatorOutputPower(11);

		// Test of deep copy - copy d1 to d2
		HlaDesignator d2 = d1.newInstance();

		// Test of deep copy - change settings of d2
		EntityIdentifierStruct d2EntityId = new EntityIdentifierStruct();
		d2EntityId.setFederateIdentifier(new FederateIdentifierStruct());
		d2EntityId.getFederateIdentifier().setSiteID((short) 22);
		d2EntityId.getFederateIdentifier().setApplicationID((short) 22);
		d2EntityId.setEntityNumber((short) 22);
		d2.setEntityIdentifier(d2EntityId);

		RelativePositionStruct d2RelPos = new RelativePositionStruct();
		d2RelPos.setBodyXDistance(22);
		d2RelPos.setBodyYDistance(22);
		d2RelPos.setBodyZDistance(22);
		d2.setRelativePosition(d2RelPos);

		WorldLocationStruct d2WorldLoc = new WorldLocationStruct();
		d2WorldLoc.setX(22);
		d2WorldLoc.setY(22);
		d2WorldLoc.setZ(22);
		d2.setDesignatorSpotLocation(d2WorldLoc);

		RelativePositionStruct d2RelSpotLoc = new RelativePositionStruct();
		d2RelSpotLoc.setBodyXDistance(22);
		d2RelSpotLoc.setBodyYDistance(22);
		d2RelSpotLoc.setBodyZDistance(22);
		d2.setRelativeSpotLocation(d2RelSpotLoc);

		AccelerationVectorStruct d2Accel = new AccelerationVectorStruct();
		d2Accel.setXAcceleration(22);
		d2Accel.setYAcceleration(22);
		d2Accel.setZAcceleration(22);
		d2.setSpotLinearAccelerationVector(d2Accel);

		d2.setDesignatorCode_Alternative(DesignatorCodeEnum16_Alternative.Other);
		d2.setCodeName_Alternative(DesignatorCodeNameEnum16_Alternative.ALRAD);
		d2.setHostObjectIdentifier("22:22:22");
		d2.setDesignatedObjectIdentifier("222:222:222");
		d2.setDeadReckoningAlgorithm(DeadReckoningAlgorithmEnum8.DRM_RPB);
		d2.setDesignatorEmissionWavelength(22);
		d2.setDesignatorOutputPower(22);

		// Test of deep copy - check if d1 is still unchanged
		assertEquals((short) 11, d1.getEntityIdentifier().getFederateIdentifier().getSiteID());
		assertEquals((short) 11, d1.getEntityIdentifier().getFederateIdentifier().getApplicationID());
		assertEquals((short) 11, d1.getEntityIdentifier().getEntityNumber());
		assertEquals((float) 11.0, d1.getRelativePosition().getBodyXDistance());
		assertEquals((float) 11.0, d1.getRelativePosition().getBodyYDistance());
		assertEquals((float) 11.0, d1.getRelativePosition().getBodyZDistance());
		assertEquals(11.0, d1.getDesignatorSpotLocation().getX());
		assertEquals(11.0, d1.getDesignatorSpotLocation().getY());
		assertEquals(11.0, d1.getDesignatorSpotLocation().getZ());
		assertEquals(11.0, d1.getRelativeSpotLocation().getBodyXDistance());
		assertEquals(11.0, d1.getRelativeSpotLocation().getBodyYDistance());
		assertEquals(11.0, d1.getRelativeSpotLocation().getBodyZDistance());
		assertEquals(11.0, d1.getSpotLinearAccelerationVector().getXAcceleration());
		assertEquals(11.0, d1.getSpotLinearAccelerationVector().getYAcceleration());
		assertEquals(11.0, d1.getSpotLinearAccelerationVector().getZAcceleration());
		assertEquals(DesignatorCodeEnum16_Alternative.Other, d1.getDesignatorCode_Alternative());
		assertEquals(DesignatorCodeNameEnum16_Alternative.AH_1_C_NITE, d1.getCodeName_Alternative());
		assertEquals("11:11:11", d1.getHostObjectIdentifier());
		assertEquals("111:111:111", d1.getDesignatedObjectIdentifier());
		assertEquals(DeadReckoningAlgorithmEnum8.Other, d1.getDeadReckoningAlgorithm());
		assertEquals(11.0, d1.getDesignatorEmissionWavelength());
		assertEquals(11.0, d1.getDesignatorOutputPower());
	}
}
