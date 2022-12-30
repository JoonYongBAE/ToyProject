package joonyong.toy.toyproject.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity //JPA가 테이블이랑 매핑을 할 수 있도록 해줌
@AllArgsConstructor //모든 필드값을 넣은 생성자를 만듦
@NoArgsConstructor // 아무 필드값도 넣지 않은 기본생성자를 만듦
@Getter //겟터를 만들어준다.
@Builder //빌더를 통해 쉽게 값을 넣어 빌드할수 있음
@ToString //값들을 String으로 변환
@DynamicInsert//insert할 때 null값이 아닌 기본값을 적용해서 넣어줌
@DynamicUpdate//update할 때 다른 값들이 Null이 되는데 일부 컬럼만 변경이 가능하도록 해줌
public class Member {

    @Id
    @Column(length = 50, updatable = false, nullable = false)
    private String id;
    @Column(nullable = false)//스프링 시큐리티를 사용하면 데이터베이스에 들어오는 번호가 길어지기 때문에 길이 제한시 오류가 날 수 있음
    private String password;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 20,nullable = false)
    private String sex;
    @Column(length = 200, nullable = false)
    private String address;
    @Column(length = 30, nullable = false)
    private String phoneNumber;
    @Column(length = 100, nullable = false)
    private String email;
    @Column
    @ColumnDefault("0")
    private int saleSuccessCount;
    @Column
    @ColumnDefault("0")
    private int greatScore;

    @ElementCollection(fetch = FetchType.EAGER)//JPA에게 컬렉션 객체라고 알려줌, 컬렉션 테이블을 생성함, EAGER 타입을 설정하면 바로 가져옴
    //@Builder.Default
    private Set<Grade> gradeSet = new HashSet<>();

    public void changeName(String name){//마이페이지에서 수정 때 사용할 메소드들
        this.name = name;
    }
    public void changePhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void changeEmail(String email){
        this.email = email;
    }
    public void changeAddress(String address){
        this.address = address;
    }
    public void changePassword(String password){
        this.password = password;
    }
    public void plusGreatScore(int greatScore){
        this.greatScore = greatScore+1;
    }
    public void minusGreatScore(int greatScore){
        this.greatScore = greatScore-1;
    }

}
