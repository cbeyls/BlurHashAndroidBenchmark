package be.digitalia.blurhashandroidbenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.wolt.blurhashkt.BlurHashDecoder
import com.wolt.blurhashkt.NewBlurHashDecoder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BlurHashDecoderBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    // Simple

    @Test
    fun originalSimpleNoCache() {
        benchmarkRule.measureRepeated {
            BlurHashDecoder.decode(FOUR_BY_FOUR_BLURHASH, SMALL_SIZE, SMALL_SIZE, useCache = false)
        }
    }

    @Test
    fun originalSimpleWithCache() {
        benchmarkRule.measureRepeated {
            BlurHashDecoder.decode(FOUR_BY_FOUR_BLURHASH, SMALL_SIZE, SMALL_SIZE, useCache = true)
        }
    }

    @Test
    fun newSimple() {
        benchmarkRule.measureRepeated {
            NewBlurHashDecoder.decode(FOUR_BY_FOUR_BLURHASH, SMALL_SIZE, SMALL_SIZE)
        }
    }

    // Complex

    @Test
    fun originalComplexNoCache() {
        benchmarkRule.measureRepeated {
            BlurHashDecoder.decode(NINE_BY_NINE_BLURHASH, LARGE_SIZE, LARGE_SIZE, useCache = false)
        }
    }

    @Test
    fun originalComplexWithCache() {
        benchmarkRule.measureRepeated {
            BlurHashDecoder.decode(NINE_BY_NINE_BLURHASH, LARGE_SIZE, LARGE_SIZE, useCache = true)
        }
    }

    @Test
    fun newComplex() {
        benchmarkRule.measureRepeated {
            NewBlurHashDecoder.decode(NINE_BY_NINE_BLURHASH, LARGE_SIZE, LARGE_SIZE)
        }
    }

    companion object {
        private const val SMALL_SIZE = 32
        private const val LARGE_SIZE = 256
        private const val FOUR_BY_FOUR_BLURHASH = "UHF5?xYk^6#M@-5b,1J5@[or[k6.};FxngOZ"
        private const val NINE_BY_NINE_BLURHASH = "|HF5]+Yk^6#M9wKSW@j=#*@-5b,1J5O[V=Nfs;w[@[or[k6.O[TLtJnNnO};FxngOZE3NgNHsps,jMFxS#OtcXnzRjxZxHj]OYNeR:JCs9xunhwIbeIpNaxHNGr;v}aeo0Xmt6XS\$et6#*\$ft6nhxHnNV@w{nOenwfNHo0"
    }
}
