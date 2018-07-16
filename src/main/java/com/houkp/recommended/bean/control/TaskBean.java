package com.houkp.recommended.bean.control;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 任务
 * 
 * @author wanght by 20180710
 */
public class TaskBean implements Serializable {
    /**
     * 命令
     */
    private int command;
    /**
     * 延迟执行时间
     */
    private int timeSlaped;

    private AdBean adBean;

    public static final long serialVersionUID = 1123223132123L;

    private final String taskId; // 任务编号


    private static final int COMMAND_START = 0;
    private static final int COMMAND_UPDATE = 1;
    private static final int COMMAND_PAUSE = 2;
    private static final int COMMAND_STOP = 3;
    private static final int COMMAND_RECOVERY = 4;



	/** 等待初始化 */
	public static final int TASK_STATE_READY = 0;
    public static final int TASK_STATE_RUNNING = 1;
    public static final int TASK_STATE_FINISHED = 2;
    public static final int TASK_STATE_PAUSED = 3;
    public static final int TASK_STATE_STOPED = 4;

	public static final Map<Integer, String> stateMap = new LinkedHashMap<Integer, String>();

	static {
		stateMap.put(TASK_STATE_READY, "空闲");
		stateMap.put(TASK_STATE_RUNNING, "投放中");
        stateMap.put(TASK_STATE_PAUSED,"暂停中");
        stateMap.put(TASK_STATE_STOPED,"终止投放");

		stateMap.put(TASK_STATE_FINISHED, "投放完成");

	}




    public String getTaskId(){
        return this.adBean.getAdUid();
    }

    public AdBean getTaskBean() {
        return adBean;
    }

    public void setTaskBean(AdBean adBean) {
        this.adBean = adBean;
    }


	public TaskBean(String taskId, AdBean adBean) {
        this.adBean = adBean;
		this.taskId = taskId;
		init();
	}

	/**
	 * 初始化<br />
	 * 调用时机为新任务初始化或一个任务周期执行完毕后进行重新初始化
	 */
	public void init() {

	}


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Task");
        sb.append("{adBean=").append(adBean);
        sb.append(", taskId=").append(taskId);
        sb.append('}');
        return sb.toString();
    }
}
