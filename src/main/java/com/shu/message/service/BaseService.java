package com.shu.message.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

/**
 * @program: message
 * @description: 所有的service继承于此，方便graphql
 * @author: 0GGmr0
 * @create: 2019-02-24 15:47
 */
public interface BaseService extends GraphQLQueryResolver, GraphQLMutationResolver {

}
