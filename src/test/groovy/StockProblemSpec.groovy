import spock.lang.Specification
import spock.lang.Unroll

class StockProblemSpec extends Specification {

    static SIMPLE = [1.00, 2.00, 3.00, 4.00, 5.00]


    @Unroll
    def "for stock data #data, you should buy at #buy, sell at #sell and your gains are #gains"() {

        when:
        def (actualBuy, actualSell, actualGains) = solveFor(data)

        then:
        actualBuy == buy
        actualSell == sell
        actualGains == gains

        where:

        data   || buy   | sell  | gains
        SIMPLE || 1.00  | 2.00  | 1.00
    }

    def solveFor(data) {
        [1.0, 2.0, 1.0]
    }

}


