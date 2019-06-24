class Synapse
{
    var from :Node? = null
    var to :Node? = null

    var resistorArray = mutableListOf<Resistor>()
    var tensionArray = mutableListOf<TensionSoure>()
    var flowSource : FlowSource? = null
    var resistance :Double
        get() {
            if(flowSource != null)
                return 0.0
            var res = 0.0
            resistorArray.forEach{
                res += it.resistanceValue
            }
            return res
        }
        set(value) {}

    var tension :Double
        get() {
            if(flowSource != null)
                return 0.0
            var tens = 0.0
            tensionArray.forEach{
                tens += it.tensionValue
            }
            return tens/resistance
        }
        set(value) {}
    var flow:Double
        get() {if(flowSource == null)
        return 0.0
        return  flowSource!!.flowValue}
        set(value) {}
}