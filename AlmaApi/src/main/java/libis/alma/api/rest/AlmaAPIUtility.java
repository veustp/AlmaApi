package libis.alma.api.rest;

import java.util.HashMap;

public class AlmaAPIUtility {
	/**
	 * ALMA_API_BASE_URL
	 * <p>
	 * constant (static final) string that contains the entry URL for Alma API Calls
	 */
	private final static String ALMA_API_BASE_URL = "https://api-eu.hosted.exlibrisgroup.com/";

	/**
	 * AlmaAPIKey()
	 * <p>
	 * Constructor
	 * <p>
	 * No implementatoin yet.<br>
	 */
	public AlmaAPIUtility () {
		//nothing yet
	}
	
	/**
	 * getAlmaAPIKey()
	 * <p>
	 * Returns the API key for a given institution.
	 * <p>
	 * @param institution insitution for which you want to get the APIkey
	 * @return APIkey string value
	 * @throws Exception
	 */
	public static String getAlmaAPIKey(String institution) throws Exception {
		try {
		HashMap<String, String> ALMA_API_KEYS = new HashMap<String, String>();
		ALMA_API_KEYS.put("ACBE","l7xxf2a8b8cd01b14f8cb4a2e11f819ed3b0");
		ALMA_API_KEYS.put("ACV","l7xxe61e5f35a2334ef1a04fc4ded41e2dac");
		ALMA_API_KEYS.put("BB","l7xx45913c3ba032408598015071f6c45452");
		ALMA_API_KEYS.put("BPB","l7xxc2a878248eb0428d8108679166a5bd6f");
		ALMA_API_KEYS.put("FIN","l7xx97b16466933e4636a6b8cb37194dc197");
		ALMA_API_KEYS.put("GROEPT","l7xxd737fe226bb24cb3bdcc073c3a7f5fe6");
		ALMA_API_KEYS.put("GSB","l7xx3c4c81eef6d44a468eba00d17c04ab28");
		ALMA_API_KEYS.put("GSG","l7xx10adc378b6434a1798e8f2550893c267");
		ALMA_API_KEYS.put("HUB","l7xx568f7b026f6a455faa96d1324680db00");
		ALMA_API_KEYS.put("IMEC","l7xx855aa5c3f30c470fafb2875959c9939c");
		ALMA_API_KEYS.put("KADOC","l7xx8879c82a7d7b453a887a6e6dca8300fd");
		ALMA_API_KEYS.put("KATHO","l7xxf983c23e124349b7bc09c6b8d81a2add");
		ALMA_API_KEYS.put("KAHO","l7xxf9c9aedbc2c443ada21e1d3509e193de");
		ALMA_API_KEYS.put("KBC","l7xxc7f9e4a7048c4f5bb2e5b64e11a42cdd");
		ALMA_API_KEYS.put("KHBO","l7xxc1832f0967a34333bbb19e1521b637c2");
		ALMA_API_KEYS.put("KHK","l7xxcba92f257978445aa94fa8de3f9f1ecd");
		ALMA_API_KEYS.put("KHL","l7xxfed6f02a62364696bb6ec6273b5746bd");
		ALMA_API_KEYS.put("KHLIM","l7xx7d39b3c073994686809d5b4e8ae4b432");
		ALMA_API_KEYS.put("KHM","l7xx8342927fd5b44dac95b55634d442bc07");
		ALMA_API_KEYS.put("KMMR","l7xxefb9413faf884f619271aeb2474e8e42");
		ALMA_API_KEYS.put("KUL","l7xxc4a95fa7d89d43048001ef9c3b5e37dc");
		ALMA_API_KEYS.put("KUL_SB","l7xx3fb46ec22b6a417a8b181866f95d9afc");
		ALMA_API_KEYS.put("LESSIUS","l7xx9f06b06efa68482bb8f727ea82093976");
		ALMA_API_KEYS.put("LIBAR","l7xx9252b3274954457e8a0c8d0202ec51f5");
		ALMA_API_KEYS.put("LUCAWENK","l7xxab3b14f6e60e4c2dbb13d7e3f5c58388");
		ALMA_API_KEYS.put("NBB","l7xxe98016c341c34d88a492a273eff411cf");
		ALMA_API_KEYS.put("NETWORK","l7xx570c20cd2e6d49188fa71d94283948e4");
		ALMA_API_KEYS.put("RBINS","l7xx7e04320695754c75b2d478cefcf9b1c1");
		ALMA_API_KEYS.put("RMCA","l7xx244422b006d54e72980a6489aac72fad");
		ALMA_API_KEYS.put("SERV","l7xxf67716ac01e74e8bbef94bd55aae9852");
		ALMA_API_KEYS.put("TIFA","l7xx68e6259372554004bae6856d5319a629");
		ALMA_API_KEYS.put("VCV","l7xx2dedd56ce1b2452abea9c14e55504ca8");
		ALMA_API_KEYS.put("VES","l7xx0fffb63fb46d45e4aa9bf41028e26d1b");
		ALMA_API_KEYS.put("VLP","l7xx2f65cc13e17f4077a581c2b23143230b");
		ALMA_API_KEYS.put("ECB","l7xx58a38371e20948b198d4ba53d775d505");
		ALMA_API_KEYS.put("ECB_SB","l7xx536f88c202344f13bb9299e68fe0da12");

			if (institution.equals("")) {
				throw new Exception ("You need to specify an institution value.");
			}
			return ALMA_API_KEYS.get(institution);
		} catch (Exception e) {
			throw new Exception("Could not find appropriate API key for institution"+institution);
		}
	}

	/**
	 * getAlmaApiBaseUrl()
	 * <p>
	 * returns the base URL for Alma API Calls
	 * <p>
	 * @return BaseUrl String
	 */
	public static String getAlmaApiBaseUrl() {
		return ALMA_API_BASE_URL;
	}

}