package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BookedDto {

    private String email;
    private String startDate;
    private String endDate;

}
