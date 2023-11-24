package vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class QNABoardVO {
    private int qnaNo;
    private int qnaPNo;
    private String memId;
    private String qnaTitle;
    private String qnaContent;
    private LocalDate qnaDate;
}
