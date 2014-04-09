package yermilov.ansimov.eliasomega

/**
 * @author yaroslav.yermilov
 */
class EliasOmega {

    def encode(String text) {
        def encoded = ""
        for (char symbol in text) {
            encoded += encode(symbol)
        }
        encoded + "0"
    }

    def decode(String encoded) {
        def decoded = ""

        def index = 1
        def determinant = 1
        while (index < encoded.length()) {
            def symbol = encoded[index]

            if (symbol == '1') {
                def decodedGroup = encoded.substring(index, index + determinant + 1)

                index = index + determinant + 1
                determinant = Integer.valueOf(decodedGroup, 2)
            } else {
                def decodedSymbol = Character.toChars(determinant)[0]
                decoded += decodedSymbol

                index++
                determinant = 1
            }
        }

        decoded
    }

    def encode(char symbol) {
        def intValue = String.valueOf(symbol).codePointAt(0)
        encode intValue
    }

    def encode(int intValue) {
        if (intValue > 1) {
            def binary = Integer.toBinaryString(intValue)
            encode(binary.length() - 1) + binary
        } else {
            "0"
        }
    }
}
