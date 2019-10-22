package zkz.kehu.common.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category implements Serializable {
    @NonNull private int category_id;//主键
    private String name;//类别名
    private int pid;//父类id
}
