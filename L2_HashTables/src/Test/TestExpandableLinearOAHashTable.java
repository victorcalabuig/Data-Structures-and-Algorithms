package Test;
// CHANGE PACKAGE NAME (P2) IF NEEDED!
import P2.*; 

public class TestExpandableLinearOAHashTable{
	public static void main(String[] args){ 

                // Check if assertions are enabled or not
                boolean assertEnabled = false;
                try {assert false;} catch (AssertionError e) {assertEnabled = true;}
                if (!assertEnabled) {
		    System.out.println("\nERROR: Please enable Java assertions, by providing the -ea option to JVM.\n");
                    System.exit(1);
                }

		System.out.println("\n***** Test 2: ExpandableLinearOAHashTable *****\n");
                int load_exceeded_count=0, assert_id=0; boolean raised = false;

                double maxLoad = 0.8;
                // CHANGE CLASS NAME (ExpandableLinearOAHashTable) IF NEEDED! 
    		ExpandableLinearOAHashTable<String,Integer> t = new ExpandableLinearOAHashTable<String,Integer>(maxLoad);

                System.out.println("\n--- CHECKING insert(), load factors and correct table expansion ---\n");

                // Insert multiple entries and check that the load factor is below maxLoad.
                // Load factor can be above maxLoad only once after performing an insert. It cannot be above maxLoad two consecutive times.
                // PLEASE ENSURE THAT MIN_BUCKETS is >= 2, otherwise the test will fail.

		assert_id=1;  try {t.insert("primero", 1);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=2;  try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=3;  try {t.insert("segundo", 2);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=4;  try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=5;  try {t.insert("tercero", 3);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=6;  try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=7;  try {t.insert("cuarto", 4);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=8;  try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=9;  try {t.insert("quinto", 5);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=10; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=11; try {t.insert("sexto", 6);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=12; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=13; try {t.insert("septimo", 7);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=13; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=15; try {t.insert("octavo", 8);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=16; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=17; try {t.insert("noveno", 9);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=18; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=19; try {t.insert("decimo", 10);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=20; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=21; try {t.insert("undecimo", 11);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=22; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=23; try {t.insert("duodecimo", 12);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=24; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=25; try {t.insert("decimotercero", 13);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=26; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=27; try {t.insert("decimocuarto", 14);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=28; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=29; try {t.insert("decimoquinto", 15);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=30; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=31; try {t.insert("decimosexto", 16);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    if (t.size()/(double)t.getM() > maxLoad) load_exceeded_count++; else load_exceeded_count = 0;
		assert_id=32; try {assert load_exceeded_count <= 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}

                // Now, check that we can retrieve all inserted entries, to assess that the expansion and entry reallocation has been done correctly

		assert_id=33; try {assert t.search("primero") == 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=34; try {assert t.search("segundo") == 2: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=35; try {assert t.search("tercero") == 3: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=36; try {assert t.search("cuarto") == 4: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=37; try {assert t.search("quinto") == 5: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=38; try {assert t.search("sexto") == 6: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=39; try {assert t.search("septimo") == 7: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=40; try {assert t.search("octavo") == 8: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=41; try {assert t.search("noveno") == 9: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=42; try {assert t.search("decimo") == 10: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=43; try {assert t.search("undecimo") == 11: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=44; try {assert t.search("duodecimo") == 12: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=45; try {assert t.search("decimotercero") == 13: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=46; try {assert t.search("decimocuarto") == 14: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=47; try {assert t.search("decimoquinto") == 15: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
		assert_id=48; try {assert t.search("decimosexto") == 16: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}

                System.out.println("\n--- ALL TESTS PASSED! (" + assert_id +" checks) ---\n");
	}
}
