package com.bootcamp.tugas3_bootcampidn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.tugas3_bootcampidn.News
import com.bootcamp.tugas3_bootcampidn.databinding.ActivityDetailNewsBinding

class DetailNewsActivity : AppCompatActivity() {

	private lateinit var binding: ActivityDetailNewsBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityDetailNewsBinding.inflate(layoutInflater)
//		setContentView(R.layout.activity_detail_news)
		setContentView(binding.root)

		val data = intent.getParcelableExtra<News>(EXTRA_NEWS)

		binding.apply {
			imgNews.setImageResource(data!!.imgNews)
			tvJudul.text = data.titleNews
			tvDeskripsi.text = data.description
			binding.tvDeskripsi.setOnClickListener{
				shareDescription(data.description)
			}
		}
	}

	private fun shareDescription(description: String) {
		val intent = Intent()
		intent.apply {
			action=Intent.ACTION_SEND
			putExtra(Intent.EXTRA_TEXT,description)
			type = "text/plain"
		}

		val shareIntent = Intent.createChooser(intent, "Share Description")
		startActivity(shareIntent)
	}

	companion object{
		const val EXTRA_NEWS="news"
	}


}