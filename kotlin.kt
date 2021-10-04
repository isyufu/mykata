
// "Pandemia 🌡️" Translation  https://www.codewars.com/kata/5e2596a9ad937f002e510435
fun infected(s: String): Double{
    val all = s.count{ it != 'X'}
    val infected = s.split('X').filter{it.contains('1')}.foldLeft(0){it.length}.toDouble()     
    return if(all == 0) 0.toDouble() else infected*100/all
}

//rangeExtraction https://www.codewars.com/kata/51ba717bb08c1cd60f00002f
fun add(m:MutableList<Pair<Int,Int>>, x:Int):MutableList<Pair<Int,Int>> {
    val v1 = x - m.last().second
    if(v1 == 0) {
    } else if(v1 == 1) {
        val last = m.last()
        m[m.size -1] = last.copy(second = x)
    } else {
        m.add(Pair(x,x))
    }
//     println("new acc: $m")
    return m
}

fun pairToStr(p:Pair<Int,Int>):String = if(p.second == p.first)
    	p.first.toString()
    else if (p.second - p.first == 1)
        "${p.first},${p.second}"
    else 
	    "${p.first}-${p.second}"

fun rangeExtraction(arr: IntArray): String {
    arr.sort()
    val res = arr.fold(mutableListOf(Pair(arr[0],arr[0])), { acc, x:Int ->  add(acc, x) }).map{pairToStr(it)}.joinToString(",")
//     println(res)
    return res
}


// Regular Expression for Binary Numbers Divisible by n https://www.codewars.com/kata/5993c1d917bc97d05d000068
fun regexDivisibleBy(n: Int): String = when (n) {
      1 -> "^[01]+?"  
      2 -> "^[01]*10[0]*?"
      3 -> "^[01]*1(0)*1[01]*?"   // !!! fix
      4 -> "^[01]*100[0]*?"
      5 -> "^[01]*(1(0)*1|)[01]*?" // !!! fix
      else -> ""
  }

fun main() {       
    println("Hello, world!!!")
    val n = 3
    val r = regexDivisibleBy(n).toRegex()
    val no = (1..100).filter{r.matches(it.toString(2)) && it % n != 0}
    val yes = (1..100).filter{r.matches(it.toString(2)) && it % n == 0}
        
    println("yes")
    yes.forEach{
        println("$it true " +it.toString(2) )
    }
    
    println("no")
     no.forEach{
        println("$it false " +it.toString(2) )
    }
    
//     assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", rangeExtraction(intArrayOf(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)))
//     assertEquals("-3--1,2,10,15,16,18-20", rangeExtraction(intArrayOf(-3, -2, -1, 2, 10, 15, 16, 18, 19, 20)))
    
//     println(infected("01000000X000X011X0X"))
//     println(infected("XXXXX"))
//     println("Hello, world!!!")
}
