package Test;
// CHANGE PACKAGE NAME (P2) IF NEEDED!
import P2.*; 

public class TestLinearOAHashTable{
	public static void main(String[] args){ 

                // Check if assertions are enabled or not
                boolean assertEnabled = false;
                try {assert false;} catch (AssertionError e) {assertEnabled = true;}
                if (!assertEnabled) {
		    System.out.println("\nERROR: Please enable Java assertions, by providing the -ea option to JVM.\n");
                    System.exit(1);
                }

                // Check if block ID is provided
                if (args.length == 0){
		    System.out.println("\nERROR: Please provide test block ID\n");
                    System.exit(1);
                }

		System.out.println("\n***** Test 1: LinearOAHashTable *****\n");
                int assert_id; boolean raised = false;

                int nbuckets = 6;
                // CHANGE CLASS NAME (LinearOAHashTable) IF NEEDED! 
    		LinearOAHashTable<String,Integer> t = new LinearOAHashTable<String,Integer>(nbuckets);

                if (args[0].equals("block1")) {
                    System.out.println("\n--- Block 1: CHECKING insert(), size() ---\n");
                    // Initial checks
    		    assert_id=1;  try {assert t.getM() == nbuckets: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=2;  try {assert t.size() == 0: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // insert("primero", 1) -> must be allocated at position 2 in the bucket vector
    		    assert_id=3;  try {t.insert("primero", 1);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=4;  try {assert t.size() == 1: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=5;  try {assert t.getKeyByBucketId(2) == "primero": "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // insert("segundo", 2) -> must be allocated at position 1 in the bucket vector
    		    assert_id=6;  try {t.insert("segundo", 2);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=7;  try {assert t.size() == 2: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=8;  try {assert t.getKeyByBucketId(1) == "segundo": "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // insert("tercero", 3) -> must be allocated at position 4 in the bucket vector
    		    assert_id=9;  try {t.insert("tercero", 3);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=10; try {assert t.size() == 3: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=11; try {assert t.getKeyByBucketId(4) == "tercero": "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // insert("cuarto", 4) -> must be allocated at position 5 in the bucket vector
    		    assert_id=12; try {t.insert("cuarto", 4);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=13; try {assert t.size() == 4: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=14; try {assert t.getKeyByBucketId(5) == "cuarto": "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // insert("quinto", 5) -> must be allocated at position 0 in the bucket vector
    		    assert_id=15; try {t.insert("quinto", 5);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=16; try {assert t.size() == 5: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=17; try {assert t.getKeyByBucketId(0) == "quinto": "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // insert("sexto", 6) -> must be allocated at position 3 in the bucket vector
    		    assert_id=18; try {t.insert("sexto", 6);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=19; try {assert t.size() == 6: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=20; try {assert t.getKeyByBucketId(3) == "sexto": "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=21;  try {assert t.getM() == nbuckets: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    System.out.println("\n--- ALL TESTS PASSED! (" + assert_id +" checks) ---\n");
                }
                else if (args[0].equals("block2")) {
                    System.out.println("\n--- Block 2: CHECKING search() ---\n");
                    // Add and search previously added entries...
    		    assert_id=1;  try {t.insert("segundo", 2);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=2;  try {assert t.search("segundo") == 2: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=3;  try {t.insert("tercero", 3);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=4;  try {assert t.search("segundo") == 2: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=5;  try {assert t.search("tercero") == 3: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=6;  try {t.insert("cuarto", 4);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=7;  try {assert t.search("segundo") == 2: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=8;  try {assert t.search("tercero") == 3: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=9;  try {assert t.search("cuarto") == 4: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=10; try {t.insert("quinto", 5);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=11; try {assert t.search("segundo") == 2: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=12; try {assert t.search("tercero") == 3: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=13; try {assert t.search("cuarto") == 4: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=14; try {assert t.search("quinto") == 5: "**** ASSERT " + assert_id +" FAILED ****";} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    assert_id=15; raised = false; try {t.search("primero");} catch (ElementNotFoundException e) {raised=true;} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                        assert raised == true: "**** ASSERT " + assert_id +" FAILED ****";
    		    System.out.println("\n--- ALL TESTS PASSED! (" + assert_id +" checks) ---\n");
                }
                else if (args[0].equals("block3")) {
                    System.out.println("\n--- Block 3: CHECKING exceptions ---\n");
                    // Add entries...
    		    assert_id=1;  try {t.insert("primero", 1);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // Check ExistingElementException
                    assert_id=2; raised = false; try {t.insert("primero", 1);} catch (ExistingElementException e) {raised=true;} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                        assert raised == true: "**** ASSERT " + assert_id +" FAILED ****";
                    // Add entries...
    		    assert_id=3;  try {t.insert("segundo", 2);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=4;  try {t.insert("tercero", 3);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=5;  try {t.insert("cuarto", 4);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
    		    assert_id=6;  try {t.insert("quinto", 5);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // Check ExistingElementException again
                    assert_id=7; raised = false; try {t.insert("tercero", 3);} catch (ExistingElementException e) {raised=true;} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                        assert raised == true: "**** ASSERT " + assert_id +" FAILED ****";
                    // Add entries...
    		    assert_id=8;  try {t.insert("sexto", 6);} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                    // Check FullDictionaryException
                    assert_id=9; raised = false; try {t.insert("septimo", 7);} catch (FullDictionaryException e) {raised=true;} catch (Exception e) {e.printStackTrace(); throw new AssertionError("**** ASSERT "+assert_id+" FAILED **** (an unexpected Exception was thrown)");}
                        assert raised == true: "**** ASSERT " + assert_id +" FAILED ****";
    		    System.out.println("\n--- ALL TESTS PASSED! (" + assert_id +" checks) ---\n");
                }
                else{
                    System.out.println("\n[EE] Unknown test ID.\n");
                    System.exit(1);
                }
    
	}
}
