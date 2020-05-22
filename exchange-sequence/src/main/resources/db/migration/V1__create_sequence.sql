create table if not exists `sequences` {
  `seq_id` bigint(20) NOT NULL COMMENT '全局序列号',
  `created_at` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  -- `prev_seq_id` bigint(20) NOT NULL,
  `symbol` varchar(32) NOT NULL COMMENT '交易对',
  PRIMARY KEY (`seq_id`),
  KEY `idx_order_id` (`order_id`)
} ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;