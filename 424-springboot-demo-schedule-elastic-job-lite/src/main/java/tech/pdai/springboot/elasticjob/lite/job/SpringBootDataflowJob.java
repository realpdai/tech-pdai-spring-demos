/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.pdai.springboot.elasticjob.lite.job;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.pdai.springboot.elasticjob.lite.entity.Foo;
import tech.pdai.springboot.elasticjob.lite.repository.FooRepository;

@Component
public class SpringBootDataflowJob implements DataflowJob<Foo> {

    private final Logger logger = LoggerFactory.getLogger(SpringBootDataflowJob.class);

    @Resource
    private FooRepository fooRepository;

    @Override
    public List<Foo> fetchData(final ShardingContext shardingContext) {
        logger.info("Item: {} | Time: {} | Thread: {} | {}",
                shardingContext.getShardingItem(), LocalDateTime.now(), Thread.currentThread().getId(), "DATAFLOW FETCH");
        return fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
    }

    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        logger.info("Item: {} | Time: {} | Thread: {} | {}",
                shardingContext.getShardingItem(), LocalDateTime.now(), Thread.currentThread().getId(), "DATAFLOW PROCESS");
        for (Foo each : data) {
            fooRepository.setCompleted(each.getId());
        }
    }
}
