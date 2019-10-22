package zkz.kehu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class PageResult<T> implements Serializable {

    private Integer page;

    private Integer size;

    private Integer total;

    private List<T> data;

}
