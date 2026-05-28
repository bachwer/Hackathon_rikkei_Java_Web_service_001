package re.edu.hackathon.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import re.edu.hackathon.constance.StatusType;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateDTO {

    @NotBlank(message = "Tiêu đề không được để trống")
    private String title;

    @NotBlank(message = "Tác giả không được để trống")
    private String author;

    @NotNull(message = "Giá sách không được để trống")
    @Min(value = 1, message = "Giá sách phải lớn hơn 0")
    private double price;

    @NotNull(message = "Trạng Thái không được để trống")
    private StatusType status;
}
