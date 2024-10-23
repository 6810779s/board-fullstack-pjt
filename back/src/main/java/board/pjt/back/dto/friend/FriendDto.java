package board.pjt.back.dto.friend;

import board.pjt.back.dto.position.PositionGetListResponseDto;
import board.pjt.back.dto.statusMessage.StatusMessageGetListResponseDto;

import java.util.List;
import java.util.Objects;

public class FriendDto {
    private StatusMessageGetListResponseDto statusMessage;
    private List<PositionGetListResponseDto> positionList;

    public FriendDto() {
    }

    public FriendDto(StatusMessageGetListResponseDto statusMessage, List<PositionGetListResponseDto> positionList) {
        this.statusMessage = statusMessage;
        this.positionList = positionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendDto friendDto = (FriendDto) o;
        return Objects.equals(statusMessage, friendDto.statusMessage) && Objects.equals(positionList, friendDto.positionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusMessage, positionList);
    }

    @Override
    public String toString() {
        return "FriendDto{" +
                "statusMessage=" + statusMessage +
                ", positionList=" + positionList +
                '}';
    }

    public StatusMessageGetListResponseDto getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(StatusMessageGetListResponseDto statusMessage) {
        this.statusMessage = statusMessage;
    }

    public List<PositionGetListResponseDto> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<PositionGetListResponseDto> positionList) {
        this.positionList = positionList;
    }
}
