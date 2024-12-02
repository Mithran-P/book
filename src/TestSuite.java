public class TestSuite {

    // Run a bunch of basic tests on PigLatinTranslator
    public static void run() {
        boolean pass = true;

        // Test cases
        pass &= basicTest("null", "ullnay");
        pass &= basicTest("", "");
        pass &= basicTest("eat", "eatay");
        pass &= basicTest("pig", "igpay");
        pass &= basicTest("trash", "ashtray");
        pass &= basicTest("pigs eat trash", "igspay eatay ashtray");
        pass &= basicTest("Trash", "Ashtray");
        pass &= basicTest("TrAsH", "Ashtray");
        pass &= basicTest("Trash.", "Ashtray.");
        pass &= basicTest("clean-cut", "eanclay-utcay");

        if (pass) {
            System.out.println("--- TEST PASSED! Congrats! ---");
        } else {
            System.out.println("--- TEST FAILED! :( ---");
        }
    }

    // Run a basic test for a single word or phrase
    public static boolean basicTest(String input, String expected) {
        String result = PigLatinTranslator.translate(input);
        if (result.equals(expected)) {
            System.out.println(" PASS: '" + input + "' -> '" + expected + "'");
            return true;
        } else {
            System.out.println(" FAIL: '" + input + "', '" + result + "' != '" + expected + "'");
            return false;
        }
    }
}
