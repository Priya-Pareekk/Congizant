package com.mockito.basics;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

public class MockitoBasicsTest {

    @Test
    public void testMockingStubbingAndVerification() {
        // 1. Mocking (Exercise 1): Create a fake instance of the interface
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stubbing (Exercise 1): Define expected behavior when called
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject the mock into our production service
        MyService service = new MyService(mockApi);

        // 3. Execution: Act on the service class
        String result = service.fetchData();

        // 4. Assertions: Verify data matches your expectations
        assertEquals("Processed: " + "Mock Data", result);

        // 5. Verification (Exercise 2): Ensure the mock's method was actually called
        verify(mockApi).getData();
        System.out.println("[MOCKITO SUCCESS]: Method stub returned correctly and invocation was verified successfully.");
    }
}