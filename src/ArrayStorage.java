/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        for (int i = 0; storage[i] != null; i++) {
            storage[i] = null;
            storageSize--;
        }
    }

    Resume[] createReturnArray() {
        Resume[] returnArray = new Resume[storageSize];
        for (int i = 0; i < storageSize; i++) {
            returnArray[i] = storage[i];
        }
        return returnArray;
    }

    void save(Resume r) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                storageSize++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        return createReturnArray()[findUuid(uuid)];
    }

    void delete(String uuid) {
        for (int i = findUuid(uuid); storage[i] != null; i++) {
            storage[i] = storage[i + 1];
        }
        storageSize--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        createReturnArray();
        return createReturnArray();
    }

    int size() {
        return storageSize;
    }

    int findUuid(String uuid) {
        int result = 0;
        for (int i = 0; i < storageSize; i++) {
            if (createReturnArray()[i].toString().equals(uuid)) {
                result = i;   //TODO exception
            }
        }
        return result;
    }
}
