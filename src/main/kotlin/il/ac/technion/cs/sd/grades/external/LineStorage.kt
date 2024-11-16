package il.ac.technion.cs.sd.grades.external

class LineStorage {
    companion object {

        private val lineList = mutableListOf<String>()

        /** Append a line to the end of the file */
        fun appendLine(line: String) {
            lineList.add(line)
        }

        /**
         * Returns the string stored at index lineNumber.
         * @throws IndexOutOfBoundsException if lineNumber < 0 or >= lineList.size
         * @throws InterruptedException if the thread woke up prematurely
         */
        fun read(lineNumber: Int): String {
            val line = lineList[lineNumber]
            Thread.sleep(line.length.toLong())
            return line
        }

        /**
         * Returns the total number of lines in the file.
         * @throws InterruptedException if the thread woke up prematurely
         */
        fun numberOfLines(): Int {
            Thread.sleep(100)
            return lineList.size
        }

        fun clear() {
            lineList.clear()
        }
    }
}