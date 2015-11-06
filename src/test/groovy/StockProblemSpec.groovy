import spock.lang.Specification
import spock.lang.Unroll

class StockProblemSpec extends Specification {
  
  @Unroll
  def "length of Spock's and his friends' names"() {
    expect:
    name.size() == length

    where:
    name     | length
    "Spock"  | 5
    "Kirk"   | 4
    "Scotty" | 6
  }
}  
