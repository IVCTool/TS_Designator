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

package nl.tno.msg.tc_designator;

import de.fraunhofer.iosb.tc_lib.TcFailed;
import de.fraunhofer.iosb.tc_lib.TcInconclusive;
import nl.tno.msg.tc_lib_designator.DesignatorBaseModel.TestItem;
import nl.tno.msg.tc_lib_designator.DesignatorBaseModel.TestItemIds;
import java.util.Map;
import org.slf4j.Logger;

/**
 * @author Rein (TNO MSG)
 */
public class TC9999_AllTests extends TC_BaseClass {
	@Override
	protected void logTestPurpose(final Logger logger) {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append("---------------------------------------------------------------------\n");
		stringBuilder.append("TEST PURPOSE\n");
		stringBuilder.append("Designator all tests\n");
		stringBuilder.append("Observe the federate for a fixed time (defined in test case parameters)\n");
		stringBuilder.append("Check requirements\n");
		stringBuilder.append("---------------------------------------------------------------------\n");
		final String testPurpose = stringBuilder.toString();
		logger.info(testPurpose);
	}

	@Override
	protected void performTest(final Logger logger) throws TcInconclusive, TcFailed {
		// Enable all test items
		for (Map.Entry<TestItemIds, TestItem> entry : designatorBaseModel.testItems.getAll().entrySet()) {
			TestItem testItem = entry.getValue();
			testItem.enable();
		}

		// Run
		runDesignatorBaseModelAndEvaluateTests(logger);
	}
}
