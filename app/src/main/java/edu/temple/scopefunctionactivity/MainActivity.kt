package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testDataArray = getTestDataArray()
        Log.d("function output", "Test Data Array: $testDataArray")

        val listOfNumbers = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        val isAverageLessThanMedian = averageLessThanMedian(listOfNumbers)
        Log.d("function output", "Is Average Less Than Median: $isAverageLessThanMedian")

        val view = getView(0, null, listOfNumbers, applicationContext)
        Log.d("function output", "Created View: $view")

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
         Log.d("function output", getTestDataArray().toString())
        Log.d("function output", getTestDataArray().toString())
        Log.d("function output", getTestDataArray().toString())

    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
    private fun getTestDataArray() = MutableList(10) { Random.nextInt() }.sorted()




    // Return true if average value in list is greater than median value, false otherwise

//
// Convert the function to check if the average is less than the median to a single-expression function
private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean {

    val avg = listOfNumbers.average()
    val median = listOfNumbers.sorted().let {
        if (it.size % 2 == 0) (it[it.size / 2] + it[(it.size - 1) / 2]) / 2 else it[it.size / 2]
    }
    return avg < median
}


    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)

    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View =
            (recycledView ?: TextView(context).apply {
                setPadding(5, 10, 10, 0)
                textSize = 22f
            }).apply {
                 text = collection[position].toString()
            }
//    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View {
//        val textView: TextView
//
//        if (recycledView != null) {
//            textView = recycledView as TextView
//        } else {
//            textView = TextView(context)
//            textView.setPadding(5, 10, 10, 0)
//            textView.textSize = 22f
//        }
//
//        textView.text = collection[position].toString()
//
//        return textView
//    }

}