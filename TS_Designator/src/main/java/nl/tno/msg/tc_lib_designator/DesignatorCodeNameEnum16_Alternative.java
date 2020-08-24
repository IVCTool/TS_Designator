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

// Replacement of original class; copied from SISO-REF-010-2018, Reference for Enumerations for Simulation Interoperability, Version 25
public enum DesignatorCodeNameEnum16_Alternative {
	Not_Specified ((short) 0),
	AN_AAQ_4 ((short) 1000),
	AN_AAQ_7 ((short) 1100),
	AN_AAQ_8 ((short) 1200),
	AN_AAQ_14_LANTIRN ((short) 1300),
	AN_AAQ_19 ((short) 1400),
	AN_AAQ_22A_SAFIRE ((short) 1500),
	AN_AAQ_22B_SAFIRE_LP ((short) 1600),
	AN_AAQ_22C_Star_SAFIRE_I ((short) 1700),
	AN_AAQ_22D_BRITE_Star ((short) 1800),
	AN_AAQ_24_V_DIRCM_Nemesis ((short) 1900),
	AN_AAQ_25_LTS ((short) 2000),
	AN_AAQ_28_V_LITENING_II ((short) 2100),
	AN_AAQ_30 ((short) 2200),
	AN_AAQ_32 ((short) 2300),
	AN_AAQ_33_Sniper ((short) 2400),
	AN_AAQ_37 ((short) 2500),
	AN_AAQ_38 ((short) 2600),
	AN_AAS_32 ((short) 2700),
	AN_AAS_35V ((short) 2800),
	AN_AAS_37 ((short) 2900),
	AN_AAS_38 ((short) 3000),
	AN_AAS_44_V ((short) 3100),
	AN_AAS_46 ((short) 3200),
	AN_AAS_49 ((short) 3300),
	AN_AAS_51 ((short) 3400),
	AN_AAS_52_MTS_A ((short) 3500),
	AN_ALQ_10 ((short) 3600),
	AN_ASQ_228 ((short) 3700),
	AN_AVQ_25 ((short) 4400),
	AN_AVQ_26 ((short) 4500),
	AN_GVS_5 ((short) 4600),
	AN_PED_1_LLDR ((short) 4700),
	TADS_LRF_D ((short) 4800),
	MMS_LRF_D ((short) 4900),
	AH_1_C_NITE ((short) 5000),
	MATES ((short) 5100),
	TCV_115 ((short) 5200),
	TIM ((short) 5300),
	TMS_303 ((short) 5400),
	TMY_303 ((short) 5500),
	ALRAD ((short) 5600),
	RFTDL ((short) 5700),
	VVLR ((short) 5800),
	P0705_HELL ((short) 6000),
	P0708_PULSE ((short) 6100),
	HELD ((short) 6200),
	TYPE_105 ((short) 6300),
	TYPE_118 ((short) 6400),
	TYPE_121 ((short) 6500),
	TYPE_126 ((short) 6600),
	TYPE_629 ((short) 6700),
	CLDS ((short) 6800),
	TAV_38 ((short) 6900),
	TMV_630 ((short) 7000),
	ALTM_1020 ((short) 7100),
	ALATS ((short) 7200),
	Dark_Star_LAMPS ((short) 7300),
	GLTD_II ((short) 7400),
	MBT_ELRF ((short) 7500),
	Mark_VII ((short) 7600),
	SIRE_V ((short) 7700),
	AN_AAQ_16B ((short) 7800),
	AN_AAQ_16D_AESOP ((short) 7900),
	AN_AAQ_21_Star_SAFIRE_III ((short) 8000),
	AN_AAQ_22E_BRITE_Star ((short) 8100),
	AN_AAQ_36_Star_SAFIRE_II ((short) 8200),
	AN_AAS_38A_Nite_Hawk ((short) 8300),
	AN_AAS_38B_Nite_Hawk ((short) 8400),
	AN_AAS_44C_V ((short) 8500),
	AN_AAS_53_CSP ((short) 8600),
	AN_ASQ_28_ATFLIR ((short) 8700),
	AN_DAS_1_MTS_B ((short) 8800),
	AN_PAQ_1_LTD ((short) 8900),
	AN_PAQ_3_MULE ((short) 9000),
	AN_PEQ_3 ((short) 9100),
	AN_TVQ_2_G_VLLD ((short) 9200),
	AN_ZSQ_2_V_1_EOS ((short) 9300),
	AN_ZSQ_2_V_2_EOS ((short) 9400),
	CIRCM ((short) 9500),
	Guardian ((short) 9600),
	IZLID_200P ((short) 9700),
	IZLID_1000P_W ((short) 9800),
	MMS ((short) 9900),
	M_TADS_PNVS_Arrowhead ((short) 10000),
	RBS_70 ((short) 10100),
	RBS_90 ((short) 10200),
	TADS_PNVS ((short) 10300);

	private final short value;

	private DesignatorCodeNameEnum16_Alternative(short value) {
		this.value = value;
	}

	public short getValue() {
		return value;
	}

	private static DesignatorCodeNameEnum16_Alternative allEnums[] = DesignatorCodeNameEnum16_Alternative.values();

	public static DesignatorCodeNameEnum16_Alternative convertShortToEnum(short shortValue) throws DecoderException {
		for (int i = 0; i < allEnums.length; i++) {
			if (shortValue == allEnums[i].getValue()) {
				return allEnums[i];
			}
		}
		String warningMsg = String.format("DesignatorCodeNameEnum16_Alternative::convertShortToEnum - failed to convert {} to DesignatorCodeNameEnum16_Alternative", shortValue);
		throw new DecoderException(warningMsg);
	}
}