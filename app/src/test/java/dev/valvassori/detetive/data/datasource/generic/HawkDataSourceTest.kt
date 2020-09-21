package dev.valvassori.detetive.data.datasource.generic

import com.orhanobut.hawk.Hawk
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

private const val TEST_KEY = "test_key"

class HawkDataSourceTest {

    private val subject = HawkDataSource<Int>(TEST_KEY)

    @Test
    fun get_callsReturnsHawkValue() {
        val expectedResult = (0..100).toList().random()
        mock(currentValue = expectedResult)

        val result = subject.get()

        assertEquals(expectedResult, result)
    }

    @Test
    fun get_callsHawkGet() {
        mock()

        subject.get()

        verify(exactly = 1) { Hawk.get<Int>(TEST_KEY) }
    }

    @Test
    fun set_callsHawkPut() {
        val expectedResult = (0..100).toList().random()
        mock()

        subject.set(expectedResult)

        verify(exactly = 1) { Hawk.put<Int>(TEST_KEY, expectedResult) }
    }

    @Test
    fun exists_callsReturnsHawkValue() {
        val expectedResult = (0..100).toList().random()
        val shouldTake = (0..100).toList().random() % 2 == 0
        mock(
            currentValue = expectedResult.takeIf { shouldTake }
        )

        val result = subject.exists()

        assertEquals(shouldTake, result)
    }

    @Test
    fun exists_callsHawkGet() {
        mock()

        subject.exists()

        verify(exactly = 1) { Hawk.contains(TEST_KEY) }
    }

    private fun mock(
        key: String = TEST_KEY,
        currentValue: Int? = null,
    ) {
        mockkStatic(Hawk::class)

        every { Hawk.get<Int>(key) } returns currentValue
        every { Hawk.put(key, any<Int>()) } returns true
        every { Hawk.contains(key) } returns (currentValue != null)
    }
}
