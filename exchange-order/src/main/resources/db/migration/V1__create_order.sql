create table if not exists `orders` (
    `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
    `symbol` varchar(32) NOT NULL COMMENT '交易对',
    `type` varchar(50) NOT NULL COMMENT '订单类型',
    `user_id` bigint(20) NOT NULL COMMENT '用户id',
    `amount` decimal(36,18) NOT NULL COMMENT '数量',
    `price` decimal(36,18) NOT NULL COMMENT '价格',
    `fee` decimal(36,18) NOT NULL COMMENT '手续费',
    `trigger_price` decimal(36,18) NOT NULL COMMENT '触发价格',
    `created_at` bigint(20) NOT NULL COMMENT '创建时间',
    `updated_at` bigint(20) NOT NULL COMMENT '最后更新时间',
    primary key (`order_id`),
    key `idx_user_id_symbol` (`user_id`, `symbol`),
    key `idx_symbol` (`symbol`)
)  ENGINE=InnoDB AUTO_INCREMENT=10000000 DEFAULT CHARSET=utf8mb4;