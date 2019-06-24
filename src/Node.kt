class Node {
    companion object {
        var nodeList = mutableListOf<Node>()
        fun updatePotential(){

            val matrix = Array<DoubleArray>(nodeList.size -1,{i-> DoubleArray(nodeList.size-1) })
            val equal = DoubleArray(nodeList.size-1,{ i-> 0.0})

            var rowID = 0

            nodeList.forEach{ row ->
                var columnId = 0
                if (row != groundedNode) {
                    nodeList.forEach{ column ->
                        if (column != groundedNode) {
                            if (column == row) {
                                row.synapses.forEach {
                                    matrix[rowID][columnId] += 1 / it.resistance
                                }
                            } else {
                                row.synapses.forEach {
                                    if ((it.from == row && it.to == column) || (it.from == column && it.to == row)) {
                                        matrix[rowID][columnId] -= 1 / it.resistance
                                    }
                                }
                            }
                            columnId ++
                        }

                    }
                    //
                    row.synapses.forEach {

                        // jesli płynie od to -
                            if (it.from == row)
                                equal[rowID] -= (it.tension + it.flow)
                            // jesli płydie do to +
                            else
                                equal[rowID] += (it.tension + it.flow)
                    }
                    rowID ++
                }
            }

            val result = Solver.lsolve(matrix,equal)
            nodeList.forEachIndexed{i,it ->
                if (groundedNode != it)
                it.potecial = result[i]
            }
            groundedNode?.potecial = 0.0
        }


        var groundedNode : Node? = null
    }
    init {
        nodeList.add(this)
        if (groundedNode == null)
            groundedNode = this
    }

    var synapses:MutableList<Synapse> = mutableListOf<Synapse>()

    var potecial:Double = 0.0
    fun destroy(){
        nodeList.remove(this)
        if (groundedNode == this)
        {
            if (nodeList.size > 0)
                groundedNode = nodeList.first()
            else{
                groundedNode = null
            }
        }
    }
}