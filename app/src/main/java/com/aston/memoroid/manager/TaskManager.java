package com.aston.memoroid.manager;

import com.aston.memoroid.common.Constants;
import com.aston.memoroid.model.Task;
import com.orhanobut.hawk.Hawk;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TaskManager {

    private static TaskManager instance;

    private List<Task> taskList;
    private boolean showDone = true;

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    private TaskManager() {
        taskList = Hawk.get(Constants.TASK_LIST, new ArrayList<Task>());
    }

    public int getTaskSize() { return getFilteredTasks().size(); }

    public Task getTaskForPosition(int position) {
        return getFilteredTasks().get(position);
    }

    private List<Task> getFilteredTasks() {
        List<Task> result = new ArrayList<>();
        for (Task t : taskList) {
            if (t.isDone()) {
                if (showDone) {
                    result.add(t);
                }
            } else {
                result.add(t);
            }
        }
        Collections.sort(result, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.getDeadline() != o2.getDeadline())
                    return Long.valueOf(o2.getDeadline() - o1.getDeadline()).intValue();
                else return o1.getPriority() - o2.getPriority();
            }
        });
        return result;
    }

    public void saveTask(Task task) {
        if (getTaskFromId(task.getId()) == null) {
            taskList.add(task);
        } else {
            taskList.set(getTaskPositionFromId(task.getId()), task);
        }
        save();
    }

    public void save() {
        Hawk.put(Constants.TASK_LIST, taskList);
    }

    public Task getTaskFromId(String id) {
        for (Task t : taskList) {
            if (StringUtils.equals(t.getId(), id)) {
                return t;
            }
        }
        return null;
    }

    public int getTaskPositionFromId(String id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (StringUtils.equals(taskList.get(i).getId(), id)) {
                return i;
            }
        }
        return 0;
    }

    public void deleteTask(String id) {
        int position = getTaskPositionFromId(id);
        taskList.remove(position);
        save();
    }

    public boolean isShowDone() {
        return showDone;
    }

    public void setShowDone(boolean showDone) {
        this.showDone = showDone;
    }
}
