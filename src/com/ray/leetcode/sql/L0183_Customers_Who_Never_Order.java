package com.ray.leetcode.sql;

import com.ray.util.Out;

/**
 * Customers Who Never Order
 * -----------------------------------------------------------------------------
 * Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.
 * Table: Customers.
 * +----+-------+
 * | Id | Name  |
 * +----+-------+
 * | 1  | Joe   |
 * | 2  | Henry |
 * | 3  | Sam   |
 * | 4  | Max   |
 * +----+-------+
 * Table: Orders.
 * +----+------------+
 * | Id | CustomerId |
 * +----+------------+
 * | 1  | 3          |
 * | 2  | 1          |
 * +----+------------+
 * Using the above tables as example, return the following:
 * +-----------+
 * | Customers |
 * +-----------+
 * | Henry     |
 * | Max       |
 * +-----------+
 *
 * Example:
 *      
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/customers-who-never-order/
 * @since   2020-03-08 19:52:36
 */
public class L0183_Customers_Who_Never_Order {
//    select c.Name as Customers from Customers c left join Orders o on c.id = o.CustomerId where o.Id is null;
}
