package nl.tno.msg.tc_designator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fraunhofer.iosb.tc_lib.AbstractTestCase;
import de.fraunhofer.iosb.tc_lib_if.IVCT_Verdict;

public class Run {

	public static void main(String[] args) {
		final Logger runLogger = LoggerFactory.getLogger(Run.class);
		AbstractTestCase[] testSchedule = new AbstractTestCase[1];
		testSchedule[0] = new TC9999_AllTests();

		// initialize
		String tsName = "TS_Designator";
		String federationName = "MAK-RPR-2.0";
		String sutName = "JFTES";
		String tcParamJson = "{ "
				+ "\"FOMfile\":  \"C:/Projects/IVCT/runtime/IVCTsut/JFTES/TS-HLA-Designator-2020/RPR_FOM_v2.0_1516-2010.xml\","
				+ "\"MIMfile\":\"C:/Projects/IVCT/runtime/IVCTsut/JFTES/TS-HLA-Designator-2020/HLAstandardMIM.xml\","
				+ "\"alwaysReportWhenTestPassesAfterFail\":\"true\","
				+ "\"initialWaitingTime\":\"1.0\","
				+ "\"totalTestCaseTime\":\"20.0\","
				+ "\"maxTimeBetweenPowerZeroAndDesignatorRemoval\":\"0.5\","
				+ "\"maxTimeBetweenHostRemovalAndDesignatorRemoval\":\"0.5\","
				+ "\"heartbeatDrNonStatic\":\"5.0\","
				+ "\"distanceThresholdDrNonStatic\":\"1.0\","
				+ "\"heartbeatDrStatic\":\"60.0\","
				+ "\"distanceThresholdDrStatic\":\"5.0\""
				+ " }";
		String settingsDesignator = "(setqb RTI_tcpPort 8989) (setqb RTI_tcpForwarderAddr \"rtiexec\")";

		// run all test cases in test suite
		int i = 0;
		while (i < testSchedule.length) {
			testSchedule[i].setSettingsDesignator(settingsDesignator);
			testSchedule[i].setFederationName(federationName);
			testSchedule[i].setSutName(sutName);
			testSchedule[i].setTcName(testSchedule[i].getClass().getName());
			testSchedule[i].setTsName(tsName);
			testSchedule[i].setTcParam(tcParamJson);

			runLogger.info("************************************************");
			runLogger.info("**************** Run Test Case {} **************", testSchedule[i].getTcName());
			testSchedule[i].setSkipOperatorMsg(true);
			IVCT_Verdict verdict = testSchedule[i].execute(runLogger);
			runLogger.info(verdict.toString());
			i++;
			runLogger.info("************************************************");
		}
		runLogger.info("**************** Test Schedule Finished ****************");

	}

}
