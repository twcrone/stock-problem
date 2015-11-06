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

    @Unroll
    def "for stock data #data, price at #time is a min value"() {

        expect:
        isMin(data, t) == expected

        where:

        data    |   t   ||  expected
        SIMPLE  |   0   ||  true
        SIMPLE  |   2   ||  false
        SIMPLE  |   4   ||  false
    }

    def solveFor(data) {
        [1.0, 2.0, 1.0]
    }

    def isMin(data, t) {
        if(t - 1 < 0) {
            true
        }
        else if(t + 1 >= data.size()) {
            false
        }
        else if(data[t] < data[t -1] && data[t] < data[t-1]) {
            true
        }
        else { false }
    }
}


