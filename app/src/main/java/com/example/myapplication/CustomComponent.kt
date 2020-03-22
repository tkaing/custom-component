package com.example.myapplication

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.view_custom_component.view.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CustomComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom_component, this, true)
        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.custom_component_attributes, 0, 0)
            val defaultText = typedArray.getString(R.styleable.custom_component_attributes_text) ?: resources.getString(R.string.default_text)
            val defaultColor = typedArray.getColor(R.styleable.custom_component_attributes_textColor, ResourcesCompat.getColor(resources, R.color.colorPrimary, null))
            val defaultImage = typedArray.getDrawable(R.styleable.custom_component_attributes_src) ?: ResourcesCompat.getDrawable(resources, R.drawable.pokeball, null);
            val hintText = resources.getString(R.string.hint_text)

            my_edit.hint = hintText
            my_edit.setText(defaultText)
            my_edit.setTextColor(defaultColor)
            my_image.setImageDrawable(defaultImage)

            typedArray.recycle()
        }
    }
}