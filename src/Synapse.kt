class Synapse
{
    var from :Node? = null
    var to :Node? = null

    var resistorArray = mutableListOf<Resistor>()
    var tensionArray = mutableListOf<TensionSoure>()
    var resistance :Double
        get() {
            var res = 0.0
            resistorArray.forEach{
                res += it.resistanceValue
            }
            return res
        }
        set(value) {}

    var tension :Double
        get() {
            var tens = 0.0
            tensionArray.forEach{
                tens += it.tensionValue
            }
            return tens/resistance
        }
        set(value) {}
}