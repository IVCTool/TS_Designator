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

import hla.rti1516e.encoding.DecoderException;

// Replacement of original class
public enum DesignatorCodeEnum16_Alternative {
	Other((short) 0);

	private final short value;

	private DesignatorCodeEnum16_Alternative(short value) {
		this.value = value;
	}

	public short getValue() {
		return value;
	}

	private static DesignatorCodeEnum16_Alternative allEnums[] = DesignatorCodeEnum16_Alternative.values();

	public static DesignatorCodeEnum16_Alternative convertShortToEnum(short shortValue) throws DecoderException {
		for (int i = 0; i < allEnums.length; i++) {
			if (shortValue == allEnums[i].getValue()) {
				return allEnums[i];
			}
		}
		String warningMsg = String.format("failed to convert %d to DesignatorCodeEnum16_Alternative", shortValue);
		throw new DecoderException(warningMsg);
	}
}
