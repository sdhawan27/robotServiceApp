create table robot(
                    robot_id serial,
                    min_battery number,
                    max_weight number,
                    battery_per_kg number,
                    walk_per_charge number,
                    PRIMARY KEY (robot_id));

create table product(
                    product_id serial,
                    price decimal(10,2),
                    PRIMARY KEY (product_id));









