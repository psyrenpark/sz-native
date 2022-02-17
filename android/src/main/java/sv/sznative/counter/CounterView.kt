package sv.sznative.counter

import android.view.LayoutInflater
import android.widget.FrameLayout
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactContext
import sv.sznative.databinding.CounterViewBinding
import com.facebook.react.uimanager.events.RCTEventEmitter

class CounterView(val context: ReactContext): FrameLayout(context) {

    private val binding : CounterViewBinding

    fun setLeftButtonText(text : String) {
        binding.button.text = text
    }

    fun setRightButtonText(text : String) {
        binding.button2.text = text
    }

    fun setValue(value : Int) {
        binding.textView.text = value.toString()
    }

    fun setupEvents() {
        val eventEmitter = context.getJSModule(RCTEventEmitter::class.java)
        binding.button.setOnClickListener{
            eventEmitter.receiveEvent(id , "pressLeftButton", null)
        }
        binding.button2.setOnClickListener{
            val event = Arguments.createMap()
            event.putString("message", "Hello world")
            eventEmitter.receiveEvent(id , "pressRightButton", event)
        }
    }

    init {
//        val view = View.inflate(context, R.layout.counter_view, this)
//        view.findViewById<TextView>(R.id.textView).text = "20"
        val inflater = LayoutInflater.from(context)
        binding = CounterViewBinding.inflate(inflater, this, true)
        this.setupEvents()
//        binding.button.text = "+1"
//        binding.button2.text = "-1"

    }
}