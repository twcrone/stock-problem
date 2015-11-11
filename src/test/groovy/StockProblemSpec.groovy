import spock.lang.Specification
import spock.lang.Unroll

class StockProblemSpec extends Specification {

    static SIMPLE = [1.00, 2.00, 3.00, 4.00, 5.00]
    static NO_GAINS = [5.00, 4.00, 3.00, 2.00, 1.00]
    static CASE1 = [2.00, 1.00, 2.00, 3.00, 4.00, 3.00]
    static CASE2 = [3.00, 2.00, 1.00, 2.00, 1.00, 2.00]
    static CASE3 = [4.00, 8.00, 3.00, 2.00, 5.00, 7.00, 3.0, 1.0]

    @Unroll
    def "for stock data #data, you should buy at #buy, sell at #sell and your gains are #gains"() {

        when:
        def solution = solveFor(data)

        then:
        solution.buy == buy
        solution.sell == sell
        solution.gains == gains

        where:

        data        || buy   | sell  | gains
        SIMPLE      || 1.00  | 5.00  | 4.00
        NO_GAINS    || 0.00  | 0.00  | 0.00
        CASE1       || 1.00  | 4.00  | 3.00
        CASE2       || 1.00  | 2.00  | 1.00
        CASE3       || 2.00  | 7.00  | 5.00
    }

    def solveFor(data) {
        def solution = [buy: 0, sell: 0, gains:0]

        for(int i = 0; i < data.size(); ++i) {
            for(int j = i + 1; j < data.size(); ++j) {
                def sell = data[j]
                def buy = data[i]
                def gains = data[j] - data[i]
                if(solution.gains < gains) {
                    solution = [buy: buy, sell: sell, gains: gains]
                }
            }
        }
        solution
    }

}


