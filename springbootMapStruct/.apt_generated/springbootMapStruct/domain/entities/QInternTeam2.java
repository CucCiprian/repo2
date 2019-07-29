package springbootMapStruct.domain.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QInternTeam2 is a Querydsl query type for InternTeam2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInternTeam2 extends EntityPathBase<InternTeam2> {

    private static final long serialVersionUID = 1252463172L;

    public static final QInternTeam2 internTeam2 = new QInternTeam2("internTeam2");

    public final DateTimePath<java.time.Instant> date = createDateTime("date", java.time.Instant.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QInternTeam2(String variable) {
        super(InternTeam2.class, forVariable(variable));
    }

    public QInternTeam2(Path<? extends InternTeam2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInternTeam2(PathMetadata metadata) {
        super(InternTeam2.class, metadata);
    }

}

