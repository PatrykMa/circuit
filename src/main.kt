
fun main(args:Array<String>)
{

    val A=Node()
    val B=Node()
    val C=Node()

    Node.groundedNode = A
    val AB = Synapse()
    val BC1 = Synapse()
    val BC2 = Synapse()
    val CA = Synapse()

    A.synapses.add(AB)
    A.synapses.add(CA)

    B.synapses.add(AB)
    B.synapses.add(BC1)
    B.synapses.add(BC2)

    C.synapses.add(CA)
    C.synapses.add(BC1)
    C.synapses.add(BC2)

    AB.from = A
    AB.to = B

    BC1.from = B
    BC1.to = C

    BC2.from = B
    BC2.to = C

    CA.from = C
    CA.to = A

    AB.resistorArray.add(Resistor().also { it.resistanceValue=1.0 })
    BC1.resistorArray.add(Resistor().also { it.resistanceValue=3.0 })
    BC2.resistorArray.add(Resistor().also { it.resistanceValue=2.0 })
    BC2.tensionArray.add(TensionSoure(5.0))
    CA.resistorArray.add(Resistor().also { it.resistanceValue=4.0 })

    Node.updatePotential()
    var x =3
    x =4
}