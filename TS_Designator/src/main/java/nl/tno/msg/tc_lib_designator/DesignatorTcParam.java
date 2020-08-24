/*
Copyright 2020, Rein (TNO MSG)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package nl.tno.msg.tc_lib_designator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;

import de.fraunhofer.iosb.tc_lib.IVCT_TcParam;
import de.fraunhofer.iosb.tc_lib.TcInconclusive;

/**
 * Store test case parameters
 *
 * @author Rein (TNO MSG)
 */
public class DesignatorTcParam implements IVCT_TcParam {
    // Get test case parameters; use some constants until we get parameters from a file
    private final int fileNum                                       = 2;
    private URL[]     urls                                          = new URL[this.fileNum];
    private boolean   alwaysReportWhenTestPassesAfterFail           = true;
    private double    initialWaitingTime                            =  0.0; // seconds
    private double    totalTestCaseTime                             = 30.0; // seconds
    private double    maxTimeBetweenPowerZeroAndDesignatorRemoval   =  0.1; // seconds
    private double    maxTimeBetweenHostRemovalAndDesignatorRemoval =  0.1; // seconds
    private double    heartbeatDrNonStatic                          =  5.0; // seconds
    private double    distanceThresholdDrNonStatic                  =  1.0; // meters
    private double    heartbeatDrStatic                             = 60.0; // seconds
    private double    distanceThresholdDrStatic                     =  5.0; // meters

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DesignatorTcParam.class);

    public DesignatorTcParam(final String paramJson) throws TcInconclusive {
    	// paramJson are not needed for this test suite

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject;
			jsonObject = (JSONObject) jsonParser.parse(paramJson);
			String s = "";

	    	// Get FOM model
			String somFile =  (String) jsonObject.get("FOMfile");
			if (somFile == null)
                throw new TcInconclusive("The key <FOMfile> was not found");
			if (somFile.isEmpty())
				throw new TcInconclusive("The key <FOMfile> is empty");
			urls[0] = (new File(somFile)).toURI().toURL();

			// Get MIM
			String mimFile =  (String) jsonObject.get("MIMfile");
			if (mimFile == null)
                throw new TcInconclusive("The key <MIMfile> was not found");
			if (mimFile.isEmpty())
				throw new TcInconclusive("The key <MIMfile> is empty");
			urls[1] = (new File(mimFile)).toURI().toURL();

			// Get alwaysReportWhenTestPassesAfterFail
			s =  (String) jsonObject.get("alwaysReportWhenTestPassesAfterFail");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key alwaysReportWhenTestPassesAfterFail was not found");
			alwaysReportWhenTestPassesAfterFail = Boolean.parseBoolean(s);

			// Get initialWaitingTime (in seconds)
			s =  (String) jsonObject.get("initialWaitingTime");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key initialWaitingTime was not found");
			initialWaitingTime = Double.parseDouble(s);
			if (initialWaitingTime < 0)
				throw new TcInconclusive("DesignatorTcParam - the key initialWaitingTime should be positive");

			// Get totalTestCaseTime (in seconds)
			s =  (String) jsonObject.get("totalTestCaseTime");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key totalTestCaseTime was not found");
			totalTestCaseTime = Double.parseDouble(s);
			if (totalTestCaseTime < 0)
				throw new TcInconclusive("DesignatorTcParam - the key totalTestCaseTime should be positive");

			// Get maxTimeBetweenPowerZeroAndDesignatorRemoval (in seconds)
			s =  (String) jsonObject.get("maxTimeBetweenPowerZeroAndDesignatorRemoval");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key maxTimeBetweenPowerZeroAndDesignatorRemoval was not found");
			maxTimeBetweenPowerZeroAndDesignatorRemoval = Double.parseDouble(s);
			if (maxTimeBetweenPowerZeroAndDesignatorRemoval < 0)
				throw new TcInconclusive("DesignatorTcParam - the key maxTimeBetweenPowerZeroAndDesignatorRemoval should be positive");

			// Get maxTimeBetweenHostRemovalAndDesignatorRemoval (in seconds)
			s =  (String) jsonObject.get("maxTimeBetweenHostRemovalAndDesignatorRemoval");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key maxTimeBetweenHostRemovalAndDesignatorRemoval was not found");
			maxTimeBetweenHostRemovalAndDesignatorRemoval = Double.parseDouble(s);
			if (maxTimeBetweenHostRemovalAndDesignatorRemoval < 0)
				throw new TcInconclusive("DesignatorTcParam - the key maxTimeBetweenHostRemovalAndDesignatorRemoval should be positive");

			// Get heartbeatDrNonStatic (in seconds)
			s =  (String) jsonObject.get("heartbeatDrNonStatic");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key heartbeatDrNonStatic was not found");
			heartbeatDrNonStatic = Double.parseDouble(s);
			if (heartbeatDrNonStatic < 0)
				throw new TcInconclusive("DesignatorTcParam - the key heartbeatDrNonStatic should be positive");

			// Get distanceThresholdDrNonStatic (in meters)
			s =  (String) jsonObject.get("distanceThresholdDrNonStatic");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key distanceThresholdDrNonStatic was not found");
			distanceThresholdDrNonStatic = Double.parseDouble(s);
			if (distanceThresholdDrNonStatic < 0)
				throw new TcInconclusive("DesignatorTcParam - the key distanceThresholdDrNonStatic should be positive");

			// Get heartbeatDrStatic (in seconds)
			s =  (String) jsonObject.get("heartbeatDrStatic");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key heartbeatDrStatic was not found");
			heartbeatDrStatic = Double.parseDouble(s);
			if (heartbeatDrStatic < 0)
				throw new TcInconclusive("DesignatorTcParam - the key heartbeatDrStatic should be positive");

			// Get distanceThresholdDrStatic (in meters)
			s =  (String) jsonObject.get("distanceThresholdDrStatic");
			if (s == null)
                throw new TcInconclusive("DesignatorTcParam - the key distanceThresholdDrStatic was not found");
			distanceThresholdDrStatic = Double.parseDouble(s);
			if (distanceThresholdDrStatic < 0)
				throw new TcInconclusive("DesignatorTcParam - the key distanceThresholdDrStatic should be positive");

        } catch (ParseException | ClassCastException e) {
            throw new TcInconclusive("DesignatorTcParam - error in parsing parameters: " + e.toString());
		} catch (MalformedURLException e) {
            throw new TcInconclusive("DesignatorTcParam - malformed URL: " + e.toString());
		}
    }

    /**
     * @return the urls
     */
    @Override
    public URL[] getUrls() {
        return this.urls;
    }

    /**
     * @return value of getAlwaysReportWhenTestPassesAfterFail
     */
    public boolean getAlwaysReportWhenTestPassesAfterFail() {
        return this.alwaysReportWhenTestPassesAfterFail;
    }

    /**
     * @return value of initial waiting time
     */
    public double getInitialWaitingTime() {
        return this.initialWaitingTime;
    }

    /**
     * @return value of total test case time
     */
    public double getTotalTestCaseTime() {
        return this.totalTestCaseTime;
    }

    /**
     * @return value of max allowed time between setting power to zero and removal of object
     */
    public double getMaxTimeBetweenPowerZeroAndDesignatorRemoval() {
        return this.maxTimeBetweenPowerZeroAndDesignatorRemoval;
    }

    /**
     * @return value of max allowed time between removal of host and removal of designator
     */
    public double getMaxTimeBetweenHostRemovalAndDesignatorRemoval() {
        return this.maxTimeBetweenHostRemovalAndDesignatorRemoval;
    }

    /**
     * @return value of heartbeatDrNonStatic
     */
    public double getHeartbeatDrNonStatic() {
        return this.heartbeatDrNonStatic;
    }


    /**
     * @return value of distanceThresholdDrNonStatic
     */
    public double getDistanceThresholdDrNonStatic() {
        return this.distanceThresholdDrNonStatic;
    }

    /**
     * @return value of heartbeatDrStatic
     */
    public double getHeartbeatDrStatic() {
        return this.heartbeatDrStatic;
    }


    /**
     * @return value of distanceThresholdDrStatic
     */
    public double getDistanceThresholdDrStatic() {
        return this.distanceThresholdDrStatic;
    }
}
