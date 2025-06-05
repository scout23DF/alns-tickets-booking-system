package de.org.dexterity.ticketsbooking.azmerp01geolocation.infrastructure.primary;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import de.org.dexterity.ticketsbooking.UnitTest;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@UnitTest
@ExtendWith(MockitoExtension.class)
class ChatResourceTest {

    private static final String ANSWER = "Hello! How can I assist you today?";

    @Mock
    private ChatLanguageModel chatLanguageModel;

    @InjectMocks
    private ChatResource chat;

    @Test
    void shouldSendMessage() {
        when(chatLanguageModel.generate("Hello")).thenReturn(ANSWER);

        assertThat(chat.send("Hello")).isEqualTo(ANSWER);
    }
}
