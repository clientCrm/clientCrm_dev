package zkz.kehu.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    @JsonSerialize(using = EnumSerializer.class)
    private HttpStatus code;

    private String message;

    private T data;

}
