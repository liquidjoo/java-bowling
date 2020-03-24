package bowling.domain.framestatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinalFrameManagementTest {

    @Test
    @DisplayName("마지막 프레임 확인")
    void checkFinalFrameStatus() {
        FinalFrameManagement finalFrameManagement = new FinalFrameManagement(10);
        FrameStatus frameStatus = finalFrameManagement.getFrameStatus();
        assertThat(frameStatus).isInstanceOf(Strike.class);

        FinalFrameManagement doubleStrike = new FinalFrameManagement(new Strike(10), 10);
        FrameStatus frameStatus1 = doubleStrike.getFrameStatus();
        assertThat(frameStatus1).isInstanceOf(Strike.class);
    }

    @Test
    @DisplayName("마지막 프레임 확인 - 스페어")
    void checkFinalFrameSpareStatus() {
        FinalFrameManagement finalFrameManagement = new FinalFrameManagement(new Miss(7), 3);
        FrameStatus frameStatus = finalFrameManagement.getFrameStatus();
        assertThat(frameStatus).isInstanceOf(Spare.class);
    }
}
