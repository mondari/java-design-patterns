package com.mondari;

/**
 * <p>
 * 客户端：客户端只能兼容目标接口
 * </p>
 *
 * @author limondar
 * @date 2022/2/26
 */
public class Client {
    private Target target;

    public Client(Target target) {
        this.target = target;
    }

    public void execute() {
        target.targetMethod();
    }
}
