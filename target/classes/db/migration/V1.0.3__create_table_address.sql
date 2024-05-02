create table public.address(
                             id bigint auto_increment primary key not null,
                             user_id bigint,
                             city varchar(255),
                             street varchar(255),
                             no varchar(255)
)