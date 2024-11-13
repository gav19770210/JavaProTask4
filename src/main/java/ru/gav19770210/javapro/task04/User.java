package ru.gav19770210.javapro.task04;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
