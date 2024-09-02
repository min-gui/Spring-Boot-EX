package hello.aop.sample.exam;

import hello.aop.sample.exam.annotation.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    @Trace
    public void reqeust(String itemId) {
        examRepository.save(itemId);
    }
}
