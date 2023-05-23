public class Epic extends Task {
    protected String[] subtasks = new String[0];

    public void save(String subtask) {
        String[] tmp = new String[subtasks.length + 1];
        for (int i = 0; i < subtasks.length; i++) {
            tmp[i] = subtasks[i];
        }
        tmp[tmp.length - 1] = subtask;
        this.subtasks = tmp;
    }

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] findAll() {
        return subtasks;
    }


    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query))
                return true;
        }
        return false;
    }
}