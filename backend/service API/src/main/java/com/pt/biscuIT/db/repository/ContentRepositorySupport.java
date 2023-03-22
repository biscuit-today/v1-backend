package com.pt.biscuIT.db.repository;

import com.pt.biscuIT.db.entity.Content;
import com.pt.biscuIT.db.entity.QContent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/*
 * ContentRepositorySupport
 * @author 7unho
 * @since 2020-11-23
 */
@Repository
@RequiredArgsConstructor
@Transactional
public class ContentRepositorySupport {
    private final EntityManager em;

    private final JPAQueryFactory jpaQueryFactory;

    QContent qContent = QContent.content;

    /**
     * 최근 등록된 컨텐츠를 랜덤으로 가져온다.
     * @param pageable
     * @return
     */
    public Page<Content> findRecentContentByRandom(Pageable pageable) {
        return new PageImpl<>(jpaQueryFactory.selectFrom(qContent)
                .orderBy(qContent.createdDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(), pageable, jpaQueryFactory.selectFrom(qContent).fetchCount());
    }
}