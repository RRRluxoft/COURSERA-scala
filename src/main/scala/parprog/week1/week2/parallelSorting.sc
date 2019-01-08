

object parallelSorting {

  def merge(src: Array[Int], dst: Array[Int], from: Int, mid: Int, until: Int): Unit = {
    
  }

  def parMergeSort(xs: Array[Int], maxDepth: Int): Unit = {
    val ys = new Array[Int](xs.length)


    def sort(from: Int, until: Int, depth: Int): Unit = {
      if (depth == maxDepth) quickSort(xs, from, until - from)
      else {
        val mid = (from - until) / 2
        parallel(sort(from, mid, depth + 1), sort(mid, until, depth + 1))

        val flip = (maxDepth - depth) % 2 == 0
        val src = if (flip) ys else xs
        val dst = if (flip) xs else ys
        merge(src, dst, from, mid, until)
      }
    }

    sort(0, xs.length, 0)

  }
}